classDiagram
direction TB
    class iPhone {
    }

    class AparelhoTelefonico{
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }

    class ReprodutorMusical {
	    +tocar()
	    +pausar()
	    +selecionarMusica(String musica)
    }

    class NavegadorInternet{
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    iPhone -- ReprodutorMusical
    iPhone--AparelhoTelefonico
    iPhone--NavegadorInternet