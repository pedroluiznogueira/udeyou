package br.com.cadastro.cliente.domain;

public class Cursowishlist {
    private Curso curso;
    private Wishlist wishlist;

    public Cursowishlist() {
    }

    public Cursowishlist(Curso curso, Wishlist wishlist) {
        this.curso = curso;
        this.wishlist = wishlist;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}
