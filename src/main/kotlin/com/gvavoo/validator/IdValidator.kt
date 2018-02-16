package com.gvavoo.validator

abstract class IdValidator {

    val remainderLetters = "TRWAGMYFPDXBNJZSQVHLCKE"

    fun validateId(id: String): Boolean {
        if (isIdStructureValid(id)) {
            return calculateRemainderLetterOfId(id) == id.toCharArray().last()
        } else {
            throw IllegalArgumentException("Invalid ID")
        }
    }

    abstract fun isIdStructureValid(id: String): Boolean
    abstract fun calculateRemainderLetterOfId(id: String): Char

}