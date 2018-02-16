package com.gvavoo.validator

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DniValidatorTest{
    val idValidator: IdValidator = DniValidator()

    @Test
    fun validateDNI_wrongNumbers() {
        var dniNumber = "94637911Q"
        assertFalse(idValidator.validateId(dniNumber))
        dniNumber = "18157005A"
        assertFalse(idValidator.validateId(dniNumber))
        dniNumber = "18157005A"
        assertFalse(idValidator.validateId(dniNumber))
    }

    @Test
    fun validateDNI_validNumbers() {
        var dniNumber = "64038825V"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "82731903Y"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "85694609J"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "76765869B"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "46185994Q"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "49589863T"
        assertTrue(idValidator.validateId(dniNumber))
        dniNumber = "61005903J"
        assertTrue(idValidator.validateId(dniNumber))
    }

    @Test(expected = IllegalArgumentException::class)
    fun validateDNI_invalidInput() {
        var dniNumber = "46185994)"
        idValidator.validateId(dniNumber)
    }
}