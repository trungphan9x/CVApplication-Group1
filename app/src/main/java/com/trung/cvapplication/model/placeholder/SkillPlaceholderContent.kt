package com.trung.cvapplication.model.placeholder

import com.trung.cvapplication.model.local.Skill
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object SkillPlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<Skill> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, Skill> = HashMap()

    private var count = 30

    init {
        // Add some sample items.
        for (i in 1..count) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Skill) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    fun addLatestItem(item: Skill) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
        count++
    }

    fun removeLatestItem() {
        val removedItemId = count-1
        ITEMS.removeAt(removedItemId)
        ITEM_MAP.remove(removedItemId.toString())
        count--
    }

    private fun createPlaceholderItem(position: Int): Skill {
        return Skill(position.toString(), "Skill $position", makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }
}