package testutils

import com.sandstonelauncher.di.configDi
import com.sandstonelauncher.di.configModules
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.koin.core.KoinApplication
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.binds
import org.koin.dsl.module
import org.mockito.kotlin.mock
import kotlin.reflect.KClass

open class BaseDiTest {
    @BeforeEach
    fun beforeEach() {
        configDi()
    }

    @AfterEach
    fun afterEach() {
        stopKoin()
    }

    protected inline fun <reified T> registerMock(mockInstance: T, bindAs: KClass<*>) {
        val mod = module {
            single { mockInstance } binds arrayOf(bindAs)
        }

        loadKoinModules(mod)
    }

    protected inline fun <reified T : Any> createMock(act: (T) -> Unit) {
        val mock = mock<T>()

        act(mock)

        registerMock(mock, T::class)
    }
}