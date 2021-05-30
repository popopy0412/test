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

Node* newRoot(){
	Node* root = (Node*)malloc(sizeof(Node)); // Root node of tree
	return root;
}

void init_card(){
	Node* root = newRoot();
	
	for(i=0;i<10;i++){
		while(1){
			int sh = rand() % NUM_SHAPE;
			int no = rand() % CARD_NUM;
			if(mark[sh][no] == 0){
				mark[sh][no] = 1;
				cards[i].num = no;
				cards[i].shape = sh;
			}
		}	
	}
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

