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


Node* tree[10]; // card tree
const char* card_shapes[NUM_SHAPE] = {"♠", "♥", "♣","◆" };
const char* card_numbers[CARD_NUM] = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
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
void checkCanShow(Node* node); // check card can show
void show_board(); // show board
void play(); // play the game

void main(){
	srand((unsigned)time(NULL));

	init_card();
	reset_board();
	
	while(1){
		show_board();
		play();
		if(top == 0){ // if there is no card
			printf("You lose.\n");
			break;
		}
		else if(tree[0]->show == -1){ // if all card is removed
			printf("You Win.\n");
			break;
		}
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
    tree[0]                  = newNode(tree[0], shapes[0], numbers[0]); // L1
	tree[1] = tree[0]->llink = newNode(tree[0]->llink, shapes[1], numbers[1]); // L2
    tree[2] = tree[0]->rlink = newNode(tree[0]->rlink, shapes[2], numbers[2]);
	tree[3] = tree[1]->llink = newNode(tree[1]->llink, shapes[3], numbers[3]); // L3
    tree[4] = tree[1]->rlink = newNode(tree[1]->rlink, shapes[4], numbers[4]);
    tree[2]->llink           = tree[1]->rlink;
    tree[5] = tree[2]->rlink = newNode(tree[2]->rlink, shapes[5], numbers[5]);
    tree[6] = tree[3]->llink = newNode(tree[3]->llink, shapes[6], numbers[6]); // L4
    tree[7] = tree[3]->rlink = newNode(tree[3]->rlink, shapes[7], numbers[7]);
    tree[4]->llink           = tree[3]->rlink;
    tree[8] = tree[4]->rlink = newNode(tree[4]->rlink, shapes[8], numbers[8]);
    tree[5]->llink           = tree[4]->rlink;
    tree[9] = tree[5]->rlink = newNode(tree[5]->rlink, shapes[9], numbers[9]); // make tree. Done.

	shuffle();

	for(int i=0;i<NUM_OF_REST_CARDS;i++){
		push_card(rest_cards[i]);
	}
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
	return ((node->llink != NULL && node->llink->show != -1) || (node->rlink != NULL && node->rlink->show != -1));
}

void push_card(int card){
	stack[top++] = card;
}

int pop_card(){
	if(top == 0) return -1;
	stack[--top] = -1;
	return 0;
}

void printCard(Node* node){
	if(node->show == -1) printf("     ");
	else (node->show ? printf("%s %s   ", card_shapes[node->shape], card_numbers[node->num]) : printf("■     "));
}

void checkCanShow(Node* node){
	node->show = (hasChild(node) ? 0 : 1);
}

void show_board(){
	for(int i=0;i<10;i++) if(tree[i]->show != -1) checkCanShow(tree[i]);

	printf("\n   0                    ");
	printCard(tree[0]);
	printf("\n  1 2                ");
	printCard(tree[1]); printCard(tree[2]);
	printf("\n 3 4 5           ");
	printCard(tree[3]); printCard(tree[4]); printCard(tree[5]);
	printf("\n6 7 8 9      ");
	printCard(tree[6]); printCard(tree[7]); printCard(tree[8]); printCard(tree[9]);
	printf("\n\n\nYou have (%d) cards.\n", top);
	printf("=============================================\n");
	printf("%s %s  ■  ■  ■  ■  ■  ■  ■  ■  ■  ■\n\n", card_shapes[stack[top-1]/13], card_numbers[stack[top-1]%13]);
	printf("Enter a number[0..9] to remove (-1 = new card) : ");
}

void play(){
	int number; // number that user input;

	if(scanf("%d", &number) == 0 || number < -1 || number > 9) { // if input is wrong
		getchar();
		printf("Wrong input.");
	}
	else if(number == -1){ // load other card
		if(pop_card()) return;
	}
	else if(0 <= number && number <= 9){ // operation about remove card
		if(tree[number]->show == -1) printf("Already removed card. Select other card"); // if card is removed
		else{
			if(tree[number]->show == 0) printf("It's not the card that shown."); // if card is not shown
			else{
				if((tree[number]->num+12)%13 == stack[top-1]%13 || (tree[number]->num+14)%13 == stack[top-1]%13){ // if card can be removed
					printf("%s %s is removed.\n", card_shapes[tree[number]->shape], card_numbers[tree[number]->num]);
					pop_card();
					push_card((tree[number]->shape)*13 + tree[number]->num);
					tree[number]->show = -1;
				}
				else{
					printf("You can't remove the card. Select other card.");
				}
			}
		}
	}
	printf("\n\n");
}
