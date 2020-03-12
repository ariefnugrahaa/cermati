package works.codex.arief.common.event

interface GlobalEvent {

    fun getName(): String

    fun getAttributes(): Map<String, Any?>
}