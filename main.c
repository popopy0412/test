#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#define NUM_SHAPE 4
#define CARD_NUM 13

const char* ctypes[NUM_SHAPE] = {"♠", "♥", "♣","◆" };
const char* ntypes[CARD_NUM] = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

typedef struct Node{
	int num;
	int shape;
	int show;
	struct Node* llink;
	struct Node* rlink;
}Node;

int mark[4][13]; // randomly pick cards

void pickCard(Node* node){ // pick card randomly
    while(1){
		int sh = rand() % NUM_SHAPE;
		int no = rand() % CARD_NUM;
		if(mark[sh][no] == 1) continue;
		mark[sh][no] = 1;
		node->shape = sh;
		node->num = no;
	}
    return;
}

void newNode(Node* node){ // create new node
	node = (Node*)malloc(sizeof(Node)); // create new node
    pickCard(node);
    node->show = 0;
    node->llink = NULL;
    node->rlink = NULL;
}

void addExistNode(Node* node, Node* exist){
    node = exist;
}

void init_card(){
	Node* root; // root node of tree
    newNode(root); // L1
    newNode(root->llink); // L2
    newNode(root->rlink);
	newNode(root->llink->llink); // L3
    newNode(root->llink->rlink);
    root->rlink->llink = root->llink->rlink;
    newNode(root->rlink->rlink);
    newNode(root->llink->llink->llink); // L4
    newNode(root->llink->llink->rlink);
    root->llink->rlink->llink = root->llink->llink->rlink;
    newNode(root->llink->rlink->rlink);
    root->rlink->rlink->llink = root->llink->rlink->rlink;
    newNode(root->rlink->rlink->rlink);
    
}

void main(){
	srand((unsigned)time(NULL));
	
	init_card();
	//reset_board();
	
	/*while(1){
		show_board();
		if(no match){
			pop_handcard(); // if no more card to play(empty stack), you lose
		}
		if(all cards removed){
			printf("\n You Win.\n");
		}
	}*/
}
