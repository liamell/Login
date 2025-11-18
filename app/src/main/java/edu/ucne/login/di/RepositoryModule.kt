package edu.ucne.login.di
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.login.data.remote.UsuarioRepositoryImpl
import edu.ucne.login.domain.repository.UsuarioRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUsuarioRepository(impl: UsuarioRepositoryImpl): UsuarioRepository
}