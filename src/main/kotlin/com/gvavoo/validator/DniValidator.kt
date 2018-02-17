package com.gvavoo.validator

class DniValidator : IdValidator() {

    val dniRegex = "(\\d{8})([A-Z])"

    override fun isIdStructureValid(dni: String): Boolean = dni.matches(Regex(dniRegex))

    override fun calculateRemainderLetterOfId(dni: String): Char {
        val numberPartOfDNI = Integer.parseInt(dni.substring(0, 8))
        val remainder = numberPartOfDNI % remainderLetters.length
        return remainderLetters.toCharArray()[remainder]
    }

}