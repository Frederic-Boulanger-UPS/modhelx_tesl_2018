package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.lang.tesl.AwaitImplication
import fr.supelec.tesl.core.Clock
import java.util.List
import java.util.LinkedList
import java.lang.reflect.Array

//* Extension methods for tesl.lang.ImplicationQualifier
class AwaitImplicationExtensions extends ExtensionWithExpressions {

    new(TESLSpec spec) {
        super(spec)
    }

    def process(AwaitImplication ai) {
        // The await is weak if the reset is strong, it is strong if the reset is weak.
        // We set it to not weak if there is no reset
        val weak = if (ai.weak) {
            false
        } else if (ai.strong) {
            true
        } else {
            false
        }
        val reset = if (ai.reset != null) {
            spec.getClock(ai.reset.name)
        } else {
            null
        }
        val target = spec.getClock(ai.target.name)
        val List<Clock<?>> masters = new LinkedList<Clock<?>>()
        for (fr.supelec.tesl.lang.tesl.Clock c : ai.masters) {
            masters.add(spec.getClock(c.name))
        }
        target.awaits(reset, weak, masters.toArray(Array.newInstance(Clock, 0) as Clock<?>[]))
    }
}