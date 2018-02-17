package com.gvavoo.validator

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DniValidatorTest{
    val idValidator: IdValidator = DniValidator()

    @Test
    fun validateDNI_wrongNumbers() {
        assertFalse(idValidator.validateId("94637911Q"))
        assertFalse(idValidator.validateId("18157005A"))
        assertFalse(idValidator.validateId("18157005A"))
    }

    @Test
    fun validateDNI_validNumbers() {
        assertTrue(idValidator.validateId("64038825V"))
        assertTrue(idValidator.validateId("82731903Y"))
        assertTrue(idValidator.validateId("85694609J"))
        assertTrue(idValidator.validateId("76765869B"))
        assertTrue(idValidator.validateId("46185994Q"))
        assertTrue(idValidator.validateId("49589863T"))
        assertTrue(idValidator.validateId("61005903J"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateDNI_invalidInput() {
        idValidator.validateId("46185994)")
    }
}