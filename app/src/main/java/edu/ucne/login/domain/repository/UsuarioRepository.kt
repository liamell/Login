package edu.ucne.login.domain.repository

import edu.ucne.login.domain.model.Usuario


interface UsuarioRepository {
    suspend fun login(userName: String, password: String): Usuario?
    suspend fun register(userName: String, password: String): Usuario
    suspend fun fetchAll(): List<Usuario>
}