#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#define NUM_SHAPE 4
#define CARD_NUM 13
#define NUM_OF_CARDS 52
#define NUM_OF_REST_CARDS 42

typedef struct Node{
	int num; // number of card
	int shape; // shape of card
	int show; // variable that is showed
	struct Node* llink; // left child of node
	struct Node* rlink; // right child of node
}Node;



Node* root; // root node of tree
Node* tree[10]; // card tree
const char* ctypes[NUM_SHAPE] = {"♠", "♥", "♣","◆" };
const char* ntypes[CARD_NUM] = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
int mark[4][13]; // randomly pick cards
int shapes[11], numbers[11]; // shapes and numbers of picked cards
int rest_cards[50];
int stack[100], top; // card deck stack

void pickCard(Node* node); // pick card randomly
Node* newNode(Node* node, int shape, int number); // create new node
void init_card(); // initialize cards
void reset_board(); // reset board
void shuffle(); // shuffle cards
int hasChild(Node* node); // check the node has child
void push_card(int card); // push card into deck
int pop_card(); // pop card from deck
void printCard(Node* node); // print Card in board
void show_board(); // show board

void main(){
	srand((unsigned)time(NULL));
	
	init_card();
	reset_board();
	
	while(1){
		show_board();
		/*if(){
			pop_card(); // if no more card to play(empty stack), you lose
		}
		if(all cards removed){
			printf("\n You Win.\n");
		}*/
	}
}

Node* newNode(Node* node, int shape, int number){ // create new node
	node = (Node*)malloc(sizeof(Node)); // create new node
    node->shape = shape;
	node->num = number;
    node->show = 0;
    node->llink = NULL;
    node->rlink = NULL;
}

/*void print(Node* node){
    if(node != NULL){
        printf("%s %s", ctypes[node->shape], ntypes[node->num]);
        print(node->llink);
        print(node->rlink);
    }
    return;
}*/

void init_card(){
	for(int i=0;i<10;i++){
		while(1){
			int sh = rand() % NUM_SHAPE;
			int no = rand() % CARD_NUM;
			if(mark[sh][no] == 1) continue;
			mark[sh][no] = 1;
			shapes[i] = sh;
			numbers[i] = no;
			break;
		}
	}
	
}

void reset_board(){
    tree[0] = root                      = newNode(root, shapes[0], numbers[0]); // L1
	tree[1] = root->llink               = newNode(root->llink, shapes[1], numbers[1]); // L2
    tree[2] = root->rlink               = newNode(root->rlink, shapes[2], numbers[2]);
	tree[3] = root->llink->llink        = newNode((root->llink)->llink, shapes[3], numbers[3]); // L3
    tree[4] = root->llink->rlink        = newNode(root->llink->rlink, shapes[4], numbers[4]);
    root->rlink->llink                  = root->llink->rlink;
    tree[5] = root->rlink->rlink        = newNode(root->rlink->rlink, shapes[5], numbers[5]);
    tree[6] = root->llink->llink->llink = newNode(root->llink->llink->llink, shapes[6], numbers[6]); // L4
    tree[7] = root->llink->llink->rlink = newNode(root->llink->llink->rlink, shapes[7], numbers[7]);
    root->llink->rlink->llink           = root->llink->llink->rlink;
    tree[8] = root->llink->rlink->rlink = newNode(root->llink->rlink->rlink, shapes[8], numbers[8]);
    root->rlink->rlink->llink           = root->llink->rlink->rlink;
    tree[9] = root->rlink->rlink->rlink = newNode(root->rlink->rlink->rlink, shapes[9], numbers[9]); // make tree. Done.

	shuffle();

	deck = (Deck*)malloc(sizeof(Deck));
	deck->top = 0;
	for(int i=0;i<NUM_OF_REST_CARDS;i++){
		push_card(deck, rest_cards[i]);
	}
    //print(root);
}

void shuffle(){
	int i, count=0; // count the rest cards
	for(i=0;i<NUM_OF_CARDS;i++){
		if(mark[i/13][i%13] == 0) rest_cards[count++] = i;
	}

	for(i=0;i<NUM_OF_REST_CARDS;i++){ // shuffle the rest cards
		int temp, random_pick = rand()%NUM_OF_REST_CARDS;

		rest_cards[temp] = rest_cards[i];
		rest_cards[i] = rest_cards[random_pick];
		rest_cards[random_pick] = rest_cards[temp];
	}
}

int hasChild(Node* node){
	return node->llink != NULL || node->rlink != NULL;
}

void push_card(Deck* deck, int card){
	deck->stack[(deck->top)++] = card;
}

int pop_card(Deck* deck){
	if(deck->top == 0) return -1;
	deck->stack[--(deck->top)] = -1;
	return 0;
}

void printCard(Node* node){
	hasChild(node) ?  printf("■  ") : printf("%s%s   ", ctypes[node->shape], ntypes[node->num]);
}

void show_board(){
	int number; // number that user input;
	printf("\n   0                    ");
	printCard(root);
	printf("\n  1 2                ");
	printCard(tree[1]); printCard(tree[2]);
	printf("\n 3 4 5           ");
	printCard(tree[3]); printCard(tree[4]); printCard(tree[5]);
	printf("\n6 7 8 9      ");
	printCard(tree[6]); printCard(tree[7]); printCard(tree[8]); printCard(tree[9]);
	printf("\n\n\nYou have (%d) cards.\n", deck->top);
	printf("=============================================\n");
	printf("%s%s  ■  ■  ■  ■  ■  ■  ■  ■  ■  ■\n\n", ctypes[deck->stack[deck->top]]);
	printf("Enter a number[0..9] to remove (-1 = new card) : ");
	scanf("%d", &number);
	if(number == -1){

	}
}
