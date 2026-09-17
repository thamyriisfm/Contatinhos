# Contatinhos 📇

Aplicativo Android para gerenciamento de contatos, desenvolvido em Kotlin.

> ⚠️ O repositório no GitHub ainda não possui descrição, tópicos ou informações detalhadas sobre as funcionalidades. Este README foi montado a partir da estrutura do projeto (arquivos Gradle) — recomendo revisar e completar as seções marcadas com `[ajustar]` com os detalhes reais do app (telas, funcionalidades, prints etc.).

## 📱 Sobre o projeto

**Contatinhos** é um app Android nativo para `[ajustar: ex. cadastrar, listar, editar e excluir contatos]`.

## ✨ Funcionalidades

- `[ajustar: ex. Adicionar novo contato]`
- `[ajustar: ex. Listar contatos cadastrados]`
- `[ajustar: ex. Editar informações de um contato]`
- `[ajustar: ex. Remover contato]`

## 🛠️ Tecnologias utilizadas

Com base nos arquivos de build do projeto:

- **Kotlin** — linguagem principal
- **Gradle (Kotlin DSL)** com **Version Catalog** (`libs.versions.toml`)
- **Android Gradle Plugin** (`com.android.application`)
- **Kotlin Android Plugin** (`org.jetbrains.kotlin.android`)
- **Hilt** — injeção de dependência (`androidHilt`)

> `[ajustar]` Caso o projeto também utilize Jetpack Compose, Room, Retrofit, ViewModel/LiveData, Navigation Component ou outras bibliotecas, vale listar aqui.

## 📂 Estrutura do projeto

```
contatinhos/
├── app/                    # Módulo principal do aplicativo Android
├── gradle/                 # Wrapper e version catalog do Gradle
├── build.gradle.kts        # Configuração de build de nível raiz
├── settings.gradle.kts     # Configuração dos módulos do projeto
└── gradle.properties       # Propriedades do Gradle
```

## ✅ Pré-requisitos

- [Android Studio](https://developer.android.com/studio) (versão recomendada: Hedgehog ou superior)
- JDK 17 (ou a versão exigida pelo Android Studio utilizado)
- SDK do Android instalado via Android Studio

## 🚀 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/thamyriisfm/contatinhos.git
   ```
2. Abra a pasta do projeto no **Android Studio**.
3. Aguarde a sincronização automática do Gradle (ou clique em **Sync Project with Gradle Files**).
4. Conecte um dispositivo físico ou inicie um emulador Android.
5. Clique em **Run ▶** para compilar e executar o aplicativo.

## 🧪 Testes

`[ajustar: descreva aqui como rodar os testes, caso existam, ex.]`
```bash
./gradlew test
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Envie para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 👩‍💻 Autora

Desenvolvido por [**thamyriisfm**](https://github.com/thamyriisfm)
