package com.trung.cvapplication.model.local

/**
 * A placeholder item representing a piece of content.
 */
data class Work(val id: String, val content: String, val details: String) {
    override fun toString(): String = content
}