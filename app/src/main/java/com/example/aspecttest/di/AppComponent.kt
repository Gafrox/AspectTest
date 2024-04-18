package com.example.aspecttest.di

import android.content.Context
import com.example.aspecttest.ui.MainActivity
import com.example.aspecttest.ui.equipments.EquipmentsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [MainModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance fragment: EquipmentsFragment
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(equipmentsFragment: EquipmentsFragment)
}