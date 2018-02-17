package com.gvavoo.validator

class NieValidator : IdValidator() {
    val nieRegex = "[XYZ]\\d{7}[A-Z]"

    override fun isIdStructureValid(nie: String): Boolean = nie.matches(Regex(nieRegex))

    override fun calculateRemainderLetterOfId(nie: String): Char {
        val firstMappedDigit: String =
                when (nie.toCharArray().first()) {
                    'X' -> "0"
                    'Y' -> "1"
                    'Z' -> "2"
                    else -> throw IllegalArgumentException("Illegal argument")
                }
        val numberPartOfNIE = Integer.parseInt(firstMappedDigit + nie.substring(1, 8))
        val remainder = numberPartOfNIE % remainderLetters.length
        return remainderLetters.toCharArray()[remainder]
    }

}