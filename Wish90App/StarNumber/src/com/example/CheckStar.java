package com.example;


import java.util.Arrays;

import static java.lang.Math.pow;

public class CheckStar {

    int givenNumber;

    CheckStar(int numb){
        this.givenNumber=numb;
    }

    public void checker() {

        int temp,numLength = 0;
        //boolean starDecider = false;
        boolean starCheckSame = false;
        boolean starCheckAscending = false;
        boolean starCheckDescending = false;
        boolean starCheck = false;
        boolean closenessSame = false;
        boolean closenessAscending = false;
        boolean closenessDescending = false;
        boolean closenessOverall = false;
        temp = givenNumber;
        int difference;


        //get length

        while (temp != 0) {
            temp = temp / 10;
            numLength++;

            // System.out.println("length now is "+numLength);
        }


        //System.out.println("length is " + numLength);

        int[] numElements = new int[numLength];
        int[] copyArray = new int[numLength];


        temp = givenNumber;

        //assign values to numElements

        for (int i = numLength - 1; i >= 0; i--) {
            numElements[i] = temp % 10;
            copyArray[i] = temp % 10;
            temp = temp / 10;
        }

        temp = givenNumber;

        //System.out.println(temp);
        //for (int i = 0; i<numLength; i++)
        //System.out.println(numElements[i]);


        //all digits are same check

        int c = 0;
        int d = 0;

        for (int i = 0; i < numLength; i++) {


            int a = temp % 10;
            if (temp > 10)
                temp = temp / 10;
            int b = temp % 10;
            //System.out.println(temp+" "+a+" "+b);
            if (a == b) {
                starCheckSame = true;
                d++;

            } else {
                starCheckSame = false;
                c++;
                //d--;
            }
            if (c != 0) {
                starCheckSame = false;
            }
            //if (starDecider){
            //  starCheck=true;
            //}
            // System.out.println(starCheckSame);

            //System.out.println(starDecider);

            //check for closeness

            if (!starCheckSame && i >= numLength - 2 && d==numLength-2){

                    closenessSame=true;
                    System.out.println("is close to same");

            }

            if(closenessSame){
                copyArray[i-1]=copyArray[0];
                copyArray[i]=copyArray[0];
            }

        }

        if(closenessSame) {
            //for (int i = 0; i < numLength; i++) {
             //   System.out.print(copyArray[i]);
            //}
            //System.out.println("");


            int closeValue= arrayToInt(copyArray,numLength);
            //System.out.println(Arrays.toString(copyArray));
            if(givenNumber<closeValue){
                difference=closeValue-givenNumber;
                System.out.println(difference);
            }

        }

        //if (!starCheckSame && d >= numLength -3) {
            //System.out.println("number is close to star same");

        //}


        System.out.println("First star value is " + starCheckSame);

        temp = givenNumber;

        //consecutive ascending digits check

        c = 0;
        d=0;
        for (int i = 0; i < numLength - 1; i++) {

            if (numElements[i] + 1 == numElements[i + 1]) {
                starCheckAscending = true;
                d++;
            } else {
                starCheckAscending = false;
                c++;
                //d--;
            }
            if (c != 0) {
                starCheckAscending = false;
            }
            //if (starDecider){
            // starCheck=true;
            //}
            // System.out.println(starCheckAscending);

            // closeness check
            if (!starCheckAscending && i >=numLength - 2 && d==numLength-2){

                    closenessAscending=true;
                    System.out.println("is close to ascending");

            }
            if (closenessAscending){
                copyArray[numLength-2]=copyArray[numLength-3]+1;
                if(copyArray[numLength-2]==10)
                    copyArray[numLength]=0;
                copyArray[numLength-1]=copyArray[numLength-2]+1;
            }

        }
        if(closenessAscending) {
            //for (int i = 0; i < numLength; i++) {
            //    System.out.print(copyArray[i]);
            //}
            //System.out.println("");


            int closeValue = arrayToInt(copyArray, numLength);
            //System.out.println(Arrays.toString(copyArray));
            if (givenNumber < closeValue) {
                difference = closeValue - givenNumber;
                System.out.println(difference);
            }
        }


        //if (!starCheckAscending && d >= numLength / 4) {
          //  System.out.println("number is close to star ascending");

        //}

        System.out.println("Second star value is " + starCheckAscending);


        //consecutive descending digits check

        c = 0;
        d = 0;
        for (int i = 0; i < numLength - 1; i++) {

            if (numElements[i] - 1 == numElements[i + 1]) {
                starCheckDescending = true;
                d++;
            } else {
                starCheckDescending = false;
                c++;
                //d--;
            }
            if (c != 0) {
                starCheckDescending = false;
            }
            //if (starDecider){
            //  starCheck=true;
            //}
            // System.out.println(starCheckDescending);


            //finding near by star number
            if (!starCheckDescending && i >=numLength - 2 && d==numLength-2){

                closenessDescending=true;
                System.out.println("is close to descending");

            }
            if (closenessDescending && copyArray[numLength-2]!=0){
                copyArray[numLength-2]=copyArray[numLength-3]-1;
                if(copyArray[numLength-2]==0)
                    copyArray[numLength-1]=9;
                else
                    copyArray[numLength-1]=copyArray[numLength-2]-1;
            }

        }

        if(closenessDescending) {
           // for (int i = 0; i < numLength; i++) {
             //   System.out.print(copyArray[i]);
            //}
            //System.out.println("");


            int closeValue = arrayToInt(copyArray, numLength);
            //System.out.println(Arrays.toString(copyArray));
            if (givenNumber < closeValue) {
                difference = closeValue - givenNumber;
                System.out.println(difference);
            }
        }


        //if (!starCheckDescending && d >= numLength / 4) {
          //  System.out.println("number is close to star descending");

        //}

        System.out.println("Third star value is " + starCheckDescending);

        if (starCheckAscending || starCheckDescending || starCheckSame) {
            starCheck = true;
        }
        System.out.println("Is it a star value: " + starCheck);


        if (closenessAscending||closenessDescending||closenessSame){
            closenessOverall = true;
        }
        System.out.println("Is it close to star value: " +closenessOverall);


    }

    private int arrayToInt(int[] arrayChange, int arrayLength){

        int obtainedInt=0;
        int j=arrayLength;

        for (int i=0; i<arrayLength;i++){

            obtainedInt= (int) (obtainedInt+(arrayChange[i]*pow(10,j-1)));
            j--;


        }
        return obtainedInt;


    }


}
