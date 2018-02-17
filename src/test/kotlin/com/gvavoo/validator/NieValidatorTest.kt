package com.gvavoo.validator


import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NieValidatorTest {
    val validator: IdValidator = NieValidator()
    @Test
    fun validateNIE_validNumbers() {
        assertTrue(validator.validateId("Z6869186B"))
        assertTrue(validator.validateId("Z6528699Q"))
        assertTrue(validator.validateId("Z5050875B"))
        assertTrue(validator.validateId("X7225471K"))
        assertTrue(validator.validateId("Z3634249R"))
    }

    @Test
    fun validateNIE_wrongNumbers() {
        assertFalse(validator.validateId("Z6869186X"))
        assertFalse(validator.validateId("Z6521699Q"))
        assertFalse(validator.validateId("Z5050872B"))
        assertFalse(validator.validateId("Z7225471K"))
        assertFalse(validator.validateId("X3633339R"))
    }


    @Test(expected = IllegalArgumentException::class)
    fun validateNIE_invalidNumbers() {
        validator.validateId("A6869186X")
    }
}