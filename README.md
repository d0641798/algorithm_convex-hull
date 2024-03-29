
#### 步驟
1. 首先創建一個 point 的 class 方便用來處理 X、Y 座標。
2. 第一步先處理第一個點，我抓的是 X 最小的點，如果有兩個點，X 座標都最小，那比較最小 Y 點，第一個點從座標系最左下角開始找。
3. 第二個使用迴圈尋找亂數點中跟第一個點做斜率為最小的點，並連成一條線。
4. 第一條線產生後使用迴圈，找尋第三個點，並做一個向量
5. 3 個點找出來，使用向量內積公式，內積=向量 A 長度*向量 B 長度*cos，Cos找到後，轉成反三角函數arc cos。
6. 得到的值為弧度，再轉成角度，使用迴圈，做判斷式讓角度處在 0 度到 180度間，並找最接近 180 度為 convex hull 中點。
7. 重複上面 4、5、6 步驟，找到所有 convex hull 點。

#### 輸入
* 輸入數字為產生點的數量

#### 輸出
* 產生convex hull


#### 結果
![DEMO](https://user-images.githubusercontent.com/43879744/167397119-6c8c42d2-3071-49f6-aef0-bbf220792c1b.png)
