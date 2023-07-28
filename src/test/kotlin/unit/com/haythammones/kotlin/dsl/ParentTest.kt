package unit.com.haythammones.kotlin.dsl

import com.haythammones.kotlin.dsl.domain.Parent
import com.haythammones.kotlin.dsl.domain.values.Job
import com.haythammones.kotlin.dsl.factory.parent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.UUID

class ParentTest {
    @Test
    fun testParentClass() {
        val parent = Parent(UUID.randomUUID(), "Name", Job.JobOne)

        assertThat(parent.name).isEqualTo("Name")
        assertThat(parent.job).isEqualTo(Job.JobOne)
        assertThat(parent.children).isEmpty()
    }

    @Test
    fun testParentFactoryCreatesDefaultsUsingKotlinDSL() {
        val parent = parent {
            name = "Name"
            job = Job.JobOne
        }

        assertThat(parent.name).isEqualTo("Name")
        assertThat(parent.job).isEqualTo(Job.JobOne)
        assertThat(parent.children).isEmpty()
    }

    @Test
    fun testParentChildrenGrandChildrenIsPossibleToCreateUsingKotlinDSL() {
        val parent = parent {
            name = "ParentName"
            job = Job.JobOne
            children {
                child {
                    name = "ChildName1"
                    grandChildren {
                        grandChild { name = "GrandChildName1" }
                        grandChild { name = "GrandChildName2" }
                    }
                }
                child {
                    name = "ChildName2"
                    grandChildren {
                        grandChild { name = "GrandChildName1" }
                    }
                }
            }
        }

        println(parent)
    }
}
