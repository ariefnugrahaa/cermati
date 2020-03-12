package works.codex.arief.common.event

import java.io.Serializable

class ScanEvent : GlobalEvent, Serializable {
    override fun getName(): String = ""

    override fun getAttributes(): Map<String, Any?> = mapOf()
}