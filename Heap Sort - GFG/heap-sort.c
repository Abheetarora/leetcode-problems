// { Driver Code Starts
// Heap Sort in C
#include <stdio.h>
  
// Function to swap the the position of two elements
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
  }
  
// Print an array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; ++i)
      printf("%d ", arr[i]);
    printf("\n");
  }
  
  
 // } Driver Code Ends
//User function Template for C


void heapify(int arr[], int size, int i) {
   // Find largest among root, left child and right child
   int L=2*i+1;
   int R=2*i+2;
   int smallest=-1;
   
   if(L<size && arr[L]<arr[i]) smallest=L;
   else smallest=i;
   if(R<size && arr[R]<arr[smallest]) smallest=R;
   if(smallest!=i){
       int temp=arr[i];
       arr[i]=arr[smallest];
       arr[smallest]=temp;
       heapify(arr , size , smallest);
   }
}

// Main function to do heap sort
void buildHeap(int arr[], int size) {
   // Build max heap
   int internalNodesRange=size/2-1;
   int i=internalNodesRange;
   for( i=internalNodesRange;i>=0;i--) {
       heapify(arr , size , i);
   }
   
   int temp[size];
   int j=0 , n=size;
   for(i=size-1;i>0;i--,j++) {
       temp[j]=arr[0];
       arr[0]=arr[size-1];
       size--;
       heapify(arr , size , 0);
   }
   temp[j]=arr[0];
   for(int i=0;i<n;i++){
       arr[i]=temp[i];
   }
}

// { Driver Code Starts.
  
// Driver code
int main() {
    int t;
    scanf("%d",&t);
    while (t--){
    int n;
    scanf("%d",&n);
    int arr[n];
    for(int i = 0; i < n; i++){
        scanf("%d",&arr[i]);
    }
    buildHeap(arr, n);
    printArray(arr, n);
    }
  }  // } Driver Code Ends