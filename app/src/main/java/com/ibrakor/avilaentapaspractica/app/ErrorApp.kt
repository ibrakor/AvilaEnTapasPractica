package com.ibrakor.avilaentapaspractica.app

sealed class ErrorApp {
    object UnknownError: ErrorApp()
    object InternetConnectionError: ErrorApp()
    object DataErrorApp: ErrorApp()
}