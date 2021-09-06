package com.example.training
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.training.kotlin.todolist.TodoActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.*

@RunWith(AndroidJUnit4::class)

class FirstUiTest {

    companion object {
        private const val EXPECTED_AMOUNT_OF_ITEMS_AFTER_ADDING = 1
        private const val EXPECTED_AMOUNT_OF_ITEMS_AFTER_DELETING = 0
    }

    private lateinit var stringToBeTyped: String

    @get:Rule
    var activityRule: ActivityScenarioRule<TodoActivity> = ActivityScenarioRule<TodoActivity>(TodoActivity::class.java)

    @Before
    fun initValidString() {
        stringToBeTyped = "Test String"
    }

    @Test
    fun addButtonExists() {
        onView(withId(R.id.btAdd))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun removeButtonExists() {
        onView(withId(R.id.btRemove))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewDisplayed() {
        onView(withId(R.id.rvTodo)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTypedTest() {
        onView(withId(R.id.etTodoTitle)).perform(typeText(stringToBeTyped), closeSoftKeyboard())
        onView(withId(R.id.btAdd)).perform(click())
        onView(withId(R.id.tvTodoTitle)).check(matches(withText(stringToBeTyped)))
        checkCountOfItemsInRecyclerview(EXPECTED_AMOUNT_OF_ITEMS_AFTER_ADDING)
        onView(withId(R.id.cbDone)).perform(click())
        onView(withId(R.id.btRemove)).perform(click())
        checkCountOfItemsInRecyclerview(EXPECTED_AMOUNT_OF_ITEMS_AFTER_DELETING)
    }

    private fun checkCountOfItemsInRecyclerview(expectedValue: Int) {
        activityRule.scenario.onActivity { activity ->
            val recyclerView = activity.findViewById<RecyclerView>(R.id.rvTodo)
            val itemCount = recyclerView.adapter?.itemCount
            assertThat(itemCount, `is`(expectedValue))
        }
    }
}