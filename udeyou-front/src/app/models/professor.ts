export class Professor {
    id?: number;
    imagem?: string;
    email?: string;
    nome?: string;
    sobrenome?: string;
    resumo?: string;
    sobre?: string;

    constructor(id?: number, imagem?: string,  email?: string, nome?: string, sobrenome?: string, resumo?: string, sobre?: string) {
        this.id = id;
        this.imagem = imagem;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.resumo = resumo;
        this.sobre = sobre;
    }
}