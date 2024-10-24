# =========================
# Projeto - Regras Gerais
# =========================
# Mantenha todas as classes do pacote principal
-keep class com.tfmdev.contatinhos.data.** { *; }

# Retém o número da linha no stack trace (para debug)
#-keepattributes SourceFile, LineNumberTable

# =========================
# Retrofit
# =========================
# Retrofit faz uso de reflexão nos parâmetros genéricos.
# InnerClasses é necessário para Signature e EnclosingMethod para InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit faz uso de anotações em métodos e parâmetros.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Manter valores padrões de anotações (e.g., retrofit2.http.Field.encoded).
-keepattributes AnnotationDefault

# Manter os parâmetros dos métodos de serviço ao otimizar.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignorar avisos sobre JSR 305 e outras dependências.
-dontwarn javax.annotation.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Com o R8, as interfaces do Retrofit criadas por Proxy podem ser removidas.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# =========================
# GSON
# =========================
# Manter classes do Gson e compatibilidade com R8
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken
-keepattributes AnnotationDefault, RuntimeVisibleAnnotations

# Impedir que o ProGuard remova informações de interface de TypeAdapter,
# TypeAdapterFactory, JsonSerializer e JsonDeserializer.
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# =========================
# Kotlin
# =========================
# Ignorar avisos relacionados a Kotlin e manter Continuation para funções suspend.
-dontwarn kotlin.Unit
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# =========================
# Google Play Services
# =========================
-keep class com.google.android.gms.internal.** { *; }

# =========================
# Teste/Debug
# =========================
# Mantenha informações de linha para melhor leitura do stack trace em crash reports.
-keepattributes SourceFile,LineNumberTable

# Ocultar o nome do arquivo original no código de origem.
#-renamesourcefileattribute SourceFile
