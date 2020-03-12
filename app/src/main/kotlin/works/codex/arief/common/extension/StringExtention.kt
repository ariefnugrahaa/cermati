package works.codex.arief.common.extension

fun String?.toCapitalSentence(): String {
    return if (this != null) {
        if (this.isNullOrBlank()) {
            ""
        } else {
            val caps = Character.toUpperCase(this.toCharArray()[0]) + this.substring(1)
            when {
                caps.contains("dki", true) -> caps.replace("Dki", "DKI")
                caps.contains("di yogya", true) -> caps.replace("di yogya", "DI Yogya")
                else -> caps
            }
        }
    } else {
        ""
    }
}