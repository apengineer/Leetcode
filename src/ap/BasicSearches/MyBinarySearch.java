package ap.BasicSearches;

class MyBinarySearch {
    public int search(int[] nums, int target) {
        int rotationIndex  = getRotationIndex(nums);
        int left = 0; int right = nums.length;
        if(target > nums[0]){
            right = rotationIndex;

        } else {
            left = rotationIndex;

        }
        return binarySearch(nums, left, right, target);

    }

    public int binarySearch(int[] nums, int left, int right, int target) {
    /*
    Binary search
    */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int getRotationIndex(int[] nums) {

        int left = 0;
        int right = nums.length;


        while(left <= right) {
            int mid = left + right / 2;

            if(nums[mid] > nums[mid+1])  return mid+1;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}