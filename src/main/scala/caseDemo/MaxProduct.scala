package caseDemo

/**
  * 最大子序列
  */
//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
//示例 1:
//
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
// 求出连续的最大的子序列，  如果 遇到负数， 则代表当前 的最小值，为当前的最大值， 进行交换，
// 记录每次迭代的最大值，     保存最大的那个结果
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-product-subarray
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
object MaxProduct {
  def main(args: Array[String]): Unit = {
    val nums = Array(-2, 3, -4);
    println(maxProduct(nums))
  }

  def maxProduct(nums: Array[Int]): Int = {
    if (nums.length == 1) {
      return nums(0)
    }
    var max = 0
    var imax: Int = 1;
    var imin: Int = 1;
    for (i <- nums) {
      if (i < 0) {
        var tmp: Int = imax
        imax = imin
        imin = tmp
      }
      imax = Math.max(imax * i, i);
      imin = Math.min(imin * i, i);

      max = Math.max(max, imax)
    }
    return max
  }
}
