package com.devbaltasarq.androidquecochecompro.Core;

public class Coche {
    public Coche()
    {
        this.suv = false;
        this.familiar = false;
        this.aireAcondicionado = false;
        this.navegador = false;
        this.comentarios = "";
    }

    public boolean esFamiliar()
    {
        return this.familiar;
    }

    public void setFamiliar(boolean familiar)
    {
        this.familiar = familiar;
    }

    public boolean esSuv()
    {
        return this.suv;
    }

    public void setSuv(boolean suv)
    {
        this.suv = suv;
    }

    public Boolean getAireAcondicionado()
    {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado)
    {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getNavegador()
    {
        return navegador;
    }

    public void setNavegador(Boolean navegador)
    {
        this.navegador = navegador;
    }

    public String getComentarios()
    {
        return this.comentarios;
    }

    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios.trim();
    }

    public String toString()
    {
        StringBuilder toret = new StringBuilder();

        toret.append( "SOFA " );

        if ( this.esSuv() ) {
            toret.append( "SUV " );
        } else {
            toret.append( "Berlina " );
        }

        if ( this.esFamiliar() ) {
            toret.append( "BREAK " );
        }

        if ( this.getAireAcondicionado() ) {
            toret.append( "a/c " );
        }

        if ( this.getNavegador() ) {
            toret.append( "navegador " );
        }

        if ( !this.getComentarios().isEmpty() ) {
            toret.append( "- ");
            toret.append( this.getComentarios() );
        }

        return toret.toString();
    }

    private Boolean suv;
    private Boolean familiar;
    private Boolean aireAcondicionado;
    private Boolean navegador;
    private String comentarios;
}
