package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Cube {

static String[][] cube = {{
	"r","r","r",
	"r","r","r",
	"r","r","r",
	},{
	"b","b","b",
	"b","b","b",
	"b","b","b",
	},{ 
	"o","o","o",
	"o","o","o",
	"o","o","o",
	},{
	"g","g","g",
	"g","g","g",
	"g","g","g",
	},{ 
	"y","y","y",
	"y","y","y",
	"y","y","y",
	},{ 
	"w","w","w",
	"w","w","w",
	"w","w","w",
	}
};

class edgedFace{
	public int currentFace;
	int[] edge1 = new int[4]; //index 0 is the face and 1-3 are the elements of the face
	int[] edge2 = new int[4]; //index 0 is the face and 1-3 are the elements of the face
	int[] edge3 = new int[4]; //index 0 is the face and 1-3 are the elements of the face
	int[] edge4 = new int[4]; //index 0 is the face and 1-3 are the elements of the face

	public edgedFace(int face){
		 currentFace = face;

		 switch(face){
			case 0: //red face
			edge1[0] = 1;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 4;
			edge2[1] = 2;
			edge2[2] = 5;
			edge2[3] = 8;

			edge3[0] = 3;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;
			edge4[1] = 2;
			edge4[2] = 5;
			edge4[3] = 8; 
			break;

			case 1: //blue face
			edge1[0] = 0;
			edge1[1] = 0;
			edge1[2] = 3;
			edge1[3] = 6;

			edge2[0] = 2;
			edge2[1] = 2;
			edge2[2] = 5;
			edge2[3] = 8;

			edge3[0] = 4;
			edge3[1] = 6;
			edge3[2] = 7;
			edge3[3] = 8;

			edge4[0] = 5;
			edge4[1] = 0;
			edge4[2] = 1;
			edge4[3] = 2; 
			break;
	
			case 2: //orange face
			edge1[0] = 1;
			edge1[1] = 0;
			edge1[2] = 3;
			edge1[3] = 6;

			edge2[0] = 3;
			edge2[1] = 2;
			edge2[2] = 5;
			edge2[3] = 8;

			edge3[0] = 4;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;
			edge4[1] = 0;
			edge4[2] = 3;
			edge4[3] = 6; 
			break;

			case 3: //green face
			edge1[0] = 0;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 2;
			edge2[1] = 0;
			edge2[2] = 3;
			edge2[3] = 6;

			edge3[0] = 4;
			edge3[1] = 0;
			edge3[2] = 1;
			edge3[3] = 2;

			edge4[0] = 5;
			edge4[1] = 6;
			edge4[2] = 7;
			edge4[3] = 8; 
			break;

			case 4: //yellow face
			edge1[0] = 0;
			edge1[1] = 0;
			edge1[2] = 1;
			edge1[3] = 2;

			edge2[0] = 1;
			edge2[1] = 0;
			edge2[2] = 1;
			edge2[3] = 2;

			edge3[0] = 2;
			edge3[1] = 0;
			edge3[2] = 1;
			edge3[3] = 2;

			edge4[0] = 3;
			edge4[1] = 0;
			edge4[2] = 1;
			edge4[3] = 2; 
			break;

			case 5: //white face
			edge1[0] = 0;
			edge1[1] = 6;
			edge1[2] = 7;
			edge1[3] = 8;

			edge2[0] = 1;
			edge2[1] = 6;
			edge2[2] = 7;
			edge2[3] = 8;

			edge3[0] = 2;
			edge3[1] = 6;
			edge3[2] = 7;
			edge3[3] = 8;

			edge4[0] = 3;
			edge4[1] = 6;
			edge4[2] = 7;
			edge4[3] = 8; 
			break;

		 }
	}

}

public void turnFace(int index, String direction){
	edgedFace eFace = new edgedFace(index);

	String[][] copy = new String [6][9];

	for(int i = 0; i < 6; i++){
		for(int j=0; j<9; j++){
			copy[i][j] = cube[i][j];
		}
	}

	switch(direction){
		case "c": //red
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		break;
		case "cc":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
		break;

	}

	switch(direction){
		case "c1": //blue
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		break;
		case "cc1":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];
		break;

	}

	switch(direction){
		case "c2": //orange
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		break;
		case "cc2":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];
		break;

	}

	switch(direction){
		case "c3": //green
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		break;
		case "cc3":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
		break;
	}

	switch(direction){
		case "c4": //yellow
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		break;
		case "cc4":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
		break;
	}

	switch(direction){
		case "c5": //white
		cube[eFace.currentFace][0] = copy[eFace.currentFace][2];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][6];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		break;
		case "cc5":
		cube[eFace.currentFace][0] = copy[eFace.currentFace][6];
		cube[eFace.currentFace][1] = copy[eFace.currentFace][3];
		cube[eFace.currentFace][2] = copy[eFace.currentFace][0];
		cube[eFace.currentFace][3] = copy[eFace.currentFace][7];
		cube[eFace.currentFace][5] = copy[eFace.currentFace][1];
		cube[eFace.currentFace][6] = copy[eFace.currentFace][8];
		cube[eFace.currentFace][7] = copy[eFace.currentFace][5];
		cube[eFace.currentFace][8] = copy[eFace.currentFace][2];

		// edge 1 changed
		cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
		cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
		cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

		// edge 2 changed
		cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
		cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
		cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

		// edge 3 changed
		cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
		cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
		cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

		// edge 4 changed
		cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
		cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
		cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
		break;
	}
}

public void showCube(){
	int ind = 0;
	for(int x=0; x<6; x++){
		for(int y=0; y<3; y++){
			for(int z=0; z<3; z++){
			System.out.print(cube[x][ind++]);

			}
			System.out.println();
		}
		ind = 0;
		System.out.println();
	}
}

public static void main(String[] args)
throws IOException
{

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	Cube RubiksCube = new Cube();


	boolean argsCheck = false;
	int argsRunIndex = 0;

	if(args.length > 0){
		argsCheck = true;
	}

	boolean proceed = true;

	while(proceed){
		String input;

		if(!argsCheck){
			input = reader.readLine();
		}else{
			if(argsRunIndex == args.length){
				argsCheck = false;
				input = "s";
			}else{
				input = args[argsRunIndex];
				argsRunIndex++;
		}
	}
		switch(input){
			case "u":
			RubiksCube.turnFace(4, "c4");
			RubiksCube.showCube();
			break;
			case "d":
			RubiksCube.turnFace(5, "c5");
			RubiksCube.showCube();
			break;
			case "r":
			RubiksCube.turnFace(0, "c");
			RubiksCube.showCube();
			break;
			case "l":
			RubiksCube.turnFace(2, "c2");
			RubiksCube.showCube();
			break;
			case "f":
			RubiksCube.turnFace(1, "c1");
			RubiksCube.showCube();
			break;
			case "b":
			RubiksCube.turnFace(3, "c3");
			RubiksCube.showCube();
			break;
			case "u'":
			RubiksCube.turnFace(4, "cc4");
			RubiksCube.showCube();
			break;
			case "d'":
			RubiksCube.turnFace(5, "cc5");
			RubiksCube.showCube();
			break;
			case "r'":
			RubiksCube.turnFace(0, "cc");
			RubiksCube.showCube();
			break;
			case "l'":
			RubiksCube.turnFace(2, "cc2");
			RubiksCube.showCube();
			break;
			case "f'":
			RubiksCube.turnFace(1, "cc1");
			RubiksCube.showCube();
			break;
			case "b'":
			RubiksCube.turnFace(3, "cc3");
			RubiksCube.showCube();
			break;
			case "s":
			break;
			case "q":
			proceed = false;
			break;

		}
	}


	RubiksCube.turnFace(0, "c");
	RubiksCube.showCube();

	}
}