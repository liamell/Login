package edu.ucne.login.domain.usecase

import edu.ucne.login.domain.model.Usuario
import edu.ucne.login.domain.repository.UsuarioRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repo: UsuarioRepository) {
    suspend operator fun invoke(userName: String, password: String): Usuario? = repo.login(userName, password)
}