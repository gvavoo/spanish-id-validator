package com.gvavoo.validator

import org.junit.Assert.*
import org.junit.Test

class NieValidatorTest {
    val validator: IdValidator = NieValidator()
    @Test
    fun validateNIE_validNumbers() {
        var nieNumber = "Z6869186B"
        assertTrue(validator.validateId(nieNumber))
        nieNumber = "Z6528699Q"
        assertTrue(validator.validateId(nieNumber))
        nieNumber = "Z5050875B"
        assertTrue(validator.validateId(nieNumber))
        nieNumber = "X7225471K"
        assertTrue(validator.validateId(nieNumber))
        nieNumber = "Z3634249R"
        assertTrue(validator.validateId(nieNumber))
    }

    @Test
    fun validateNIE_wrongNumbers() {
        var nieNumber = "Z6869186X"
        assertFalse(validator.validateId(nieNumber))
        nieNumber = "Z6521699Q"
        assertFalse(validator.validateId(nieNumber))
        nieNumber = "Z5050872B"
        assertFalse(validator.validateId(nieNumber))
        nieNumber = "Z7225471K"
        assertFalse(validator.validateId(nieNumber))
        nieNumber = "X3633339R"
        assertFalse(validator.validateId(nieNumber))
    }


    @Test(expected = IllegalArgumentException::class)
    fun validateNIE_invalidNumbers() {
        var nieNumber = "A6869186X"
        validator.validateId(nieNumber)
    }
}