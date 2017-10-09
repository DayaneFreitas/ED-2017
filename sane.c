
#include <stdio.h>
#include <stdlib.h>

typedef unsigned long long Hexa;

typedef struct {
    Hexa ptr;
    Hexa ptr_a;
    Hexa ptr_p;
    int verif;
}tPtr;

typedef struct no{
    tPtr dado;
    struct no *prox;
}tNo;

typedef struct lista{
    struct no *cabeca;
    int tamanho;
}tLista;

typedef struct nop {
    tPtr conteudo;
    struct  no *prox;
} tNop;

typedef struct{
    tNop *topo;
    int tam;
}tPilha;

void cria(tLista *lista);
void insereInicio(tLista *lista, Hexa atual, Hexa ant, Hexa prox);
void inserePos(tLista *lista, int pos, int valor);
void exibir(tLista lista);

void criap (tPilha *pilha);
int vazia (tPilha pilha);
int tamanho (tPilha pilha);
int top (tPilha pilha, int *dado);
int push(tPilha *pilha, Hexa atual, Hexa ant, Hexa prox, int verif);
int pop (tPilha *pilha, Hexa *valor );

int main(){

struct lista minhalista;
tPilha pilha;
Hexa a,b,c,exibirtop,aux_a;
cria(&minhalista);
criap(&pilha);
int i=1,j=1,cont = 0;
tNop *aux3;

while(((int)scanf("%x %x %x\n", &a, &b, &c))==3){
   insereInicio(&minhalista, a, b, c);

}

tNo *aux = minhalista.cabeca;

while(1){

    while(i){
        if(aux->dado.verif==1 && aux!=NULL){
            Hexa atual = aux->dado.ptr;
            Hexa ant = aux->dado.ptr_a;
            Hexa prox = aux->dado.ptr_p;
            int verif = aux->dado.verif;
            push(&pilha, atual, ant, prox, verif);
            i=0;
        }else{
            aux = aux->prox;
        }
    }
        aux = minhalista.cabeca;

        if(((int)aux3->conteudo.ptr_p)==0 || cont > minhalista.tamanho){
                printf("insana\n");
                return 0;
            }

    while(j && aux!=NULL){
        aux3 = pilha.topo;

        if(((int)aux3->conteudo.ptr_p) == ((int)aux->dado.ptr)){
            Hexa atual = aux->dado.ptr;
            Hexa ant = aux->dado.ptr_a;
            Hexa prox = aux->dado.ptr_p;
            int verif = aux->dado.verif;
            push(&pilha, atual, ant, prox, verif);
            cont = 0;

            if(aux->dado.verif == 2){
                j=0;
            }
            break;
        }else{
            aux = aux->prox;
            cont++;
        }
    }

   if(j==0){
    break;
   }
}

pop(&pilha, &aux_a);

while(1){

    aux3 = pilha.topo;

    if(((int)aux3->conteudo.verif == 1)&&((int)aux_a)==((int)aux3->conteudo.ptr)){
        printf("sana\n");
        break;
    }

    if(((int)aux_a)==((int)aux3->conteudo.ptr)){
        pop(&pilha, &aux_a);
    }else{
        printf("insana\n");
        break;
    }
}

return 0;
}

void cria(tLista *lista){
    lista->cabeca = NULL;
    lista->tamanho = 0;
}

void insereInicio(tLista *lista, Hexa atual, Hexa ant, Hexa prox){
    tNo *novoNo;

    novoNo = malloc(sizeof(tNo));
    novoNo->dado.ptr = atual;
    novoNo->dado.ptr_a = ant;
    novoNo->dado.ptr_p = prox;
    novoNo->prox = lista->cabeca;
    lista->cabeca = novoNo;
    lista->tamanho++;

    if(lista->tamanho == 1 || lista->tamanho == 2){
        novoNo->dado.verif = lista->tamanho;
    }else{
        novoNo->dado.verif = 0;
    }
}


void exibir(tLista lista){
    int i;
    tNo *ptr = lista.cabeca;
    if((lista.tamanho)==0){
        printf("empty\n");

    } else{
        printf("\n");
        for(i=0; i < lista.tamanho; i++){
           // printf("%x ", ptr->dado.ptr);
            //printf("%x ", ptr->dado.ptr_a);
            //printf("%x\n", ptr->dado.ptr_p);
            printf("%x ", ptr->dado.verif);
            ptr = ptr->prox;
        }
        printf("\n");
    }
}

//-----------PILHA------------------------

void criap (tPilha *pilha) {
    pilha->topo = NULL;
    pilha->tam = 0;
}

int vazia (tPilha pilha) {
    if (pilha.tam == 0){
        return 1;
    }
    else{
        return 0;
    }
}

int tamanho (tPilha pilha) {
    return pilha.tam;

/*    tPilha *p = pilha.topo;
    int i = 0;
    while(p != NULL){
            p = p->prox;
            i++;
    }
    return i;
*/
}

int top (tPilha pilha, int *dado) {
    if (vazia(pilha)){
        return 0; /* Pilha vazia */
    }

    *dado = (pilha.topo)->conteudo.verif;
    return 1;

}

int push(tPilha *pilha, Hexa atual, Hexa ant, Hexa prox, int verif) {
    tNop *novoNo; /* variavel que vai armazenar novo no*/

    /* Aloca memoria para novo no */
    novoNo = (tNop *) malloc(sizeof(tNo));
    if (novoNo == NULL){
            return 0; /* mem. insufic. */
    }

    /* Preenche o campo dado do novo no com o valor que deseja empilhar */
    novoNo->conteudo.ptr = atual;
    novoNo->conteudo.ptr_a = ant;
    novoNo->conteudo.ptr_p = prox;
    novoNo->conteudo.verif = verif;
    /* Faz o novo no apontar pro atual topo da pilha */
    novoNo->prox = pilha->topo;

    /* Atualiza o topo da pilha que agora sera o novo nó */
    pilha->topo = novoNo;

    /* Atualiza o tamanho da pilha */
    pilha->tam++;

    return 1;
}

int pop (tPilha *pilha, Hexa *valor ) {
    tNop *p;
    if (vazia(*pilha)) {
            return 0; /* pilha vazia */
    }
    /* Guarda o no que é o atual topo da pilha */
    p = pilha->topo;
    /* Guarda o valor do topo da pilha */
    *valor = p->conteudo.ptr_a;

    /* Modifica o topo da pilha para ser o proximo elemento (2o elemento da pilha) */
    /* Isso equivale a retirar o 1o elemento (topo) da pilha */
    pilha->topo = p->prox;

    /* Decrementa o tamanho da pilha */
    pilha->tam--;

    /* Libera a memoria do elemento desempilhado (p) */
    free(p);

    return 1;
}
