# [level 1] [PCCE 기출문제] 10번 / 데이터 분석 - 250121 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/250121?language=java) 

### 성능 요약

메모리: 83.4 MB, 시간: 7.33 ms

### 구분

코딩테스트 연습 > PCCE 기출문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 09월 05일 15:20:53

### 문제 설명

<p style="user-select: auto !important;">AI 엔지니어인 현식이는 데이터를 분석하는 작업을 진행하고 있습니다. 데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.</p>

<p style="user-select: auto !important;">예를 들어 다음과 같이 데이터가 주어진다면</p>
<div class="highlight" style="user-select: auto !important;"><pre class="codehilite" style="user-select: auto !important;"><code style="user-select: auto !important;">data = [[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]
</code></pre></div>
<p style="user-select: auto !important;">이 데이터는 다음 표처럼 나타낼 수 있습니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">code</th>
<th style="user-select: auto !important;">date</th>
<th style="user-select: auto !important;">maximum</th>
<th style="user-select: auto !important;">remain</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">20300104</td>
<td style="user-select: auto !important;">100</td>
<td style="user-select: auto !important;">80</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">20300804</td>
<td style="user-select: auto !important;">847</td>
<td style="user-select: auto !important;">37</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">20300401</td>
<td style="user-select: auto !important;">10</td>
<td style="user-select: auto !important;">8</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">주어진 데이터 중 "제조일이 20300501 이전인 물건들을 현재 수량이 적은 순서"로 정렬해야 한다면 조건에 맞게 가공된 데이터는 다음과 같습니다.</p>
<div class="highlight" style="user-select: auto !important;"><pre class="codehilite" style="user-select: auto !important;"><code style="user-select: auto !important;">data = [[3,20300401,10,8],[1,20300104,100,80]]
</code></pre></div>
<p style="user-select: auto !important;">정렬한 데이터들이 담긴 이차원 정수 리스트 <code style="user-select: auto !important;">data</code>와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 <code style="user-select: auto !important;">ext</code>, 뽑아낼 정보의 기준값을 나타내는 정수 <code style="user-select: auto !important;">val_ext</code>, 정보를 정렬할 기준이 되는 문자열 <code style="user-select: auto !important;">sort_by</code>가 주어집니다.</p>

<p style="user-select: auto !important;"><strong style="user-select: auto !important;"><code style="user-select: auto !important;">data</code>에서 <code style="user-select: auto !important;">ext</code> 값이 <code style="user-select: auto !important;">val_ext</code>보다 작은 데이터만 뽑은 후, <code style="user-select: auto !important;">sort_by</code>에 해당하는 값을 기준으로 오름차순으로 정렬</strong>하여 return 하도록 solution 함수를 완성해 주세요. 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.</p>

<hr style="user-select: auto !important;">

<h4 style="user-select: auto !important;">제한사항</h4>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">1 ≤ <code style="user-select: auto !important;">data</code>의 길이 ≤ 500

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;"><code style="user-select: auto !important;">data[i]</code>의 원소는 [코드 번호(code), 제조일(date), 최대 수량(maximum), 현재 수량(remain)] 형태입니다.</li>
<li style="user-select: auto !important;">1 ≤ 코드 번호≤ 100,000</li>
<li style="user-select: auto !important;">20000101 ≤ 제조일≤ 29991231</li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">data[i][1]</code>은 yyyymmdd 형태의 값을 가지며, 올바른 날짜만 주어집니다. (yyyy : 연도, mm : 월, dd : 일)</li>
<li style="user-select: auto !important;">1 ≤ 최대 수량≤ 10,000</li>
<li style="user-select: auto !important;">1 ≤ 현재 수량≤ 최대 수량</li>
</ul></li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">ext</code>와 <code style="user-select: auto !important;">sort_by</code>의 값은 다음 중 한 가지를 가집니다.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">"code", "date", "maximum", "remain"</li>
<li style="user-select: auto !important;">순서대로 코드 번호, 제조일, 최대 수량, 현재 수량을 의미합니다.</li>
</ul></li>
<li style="user-select: auto !important;"><code style="user-select: auto !important;">val_ext</code>는 <code style="user-select: auto !important;">ext</code>에 따라 올바른 범위의 숫자로 주어집니다.</li>
<li style="user-select: auto !important;">정렬 기준에 해당하는 값이 서로 같은 경우는 없습니다.</li>
</ul>

<hr style="user-select: auto !important;">

<h4 style="user-select: auto !important;">입출력 예</h4>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">data</th>
<th style="user-select: auto !important;">ext</th>
<th style="user-select: auto !important;">val_ext</th>
<th style="user-select: auto !important;">sort_by</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">[[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]</td>
<td style="user-select: auto !important;">"date"</td>
<td style="user-select: auto !important;">20300501</td>
<td style="user-select: auto !important;">"remain"</td>
<td style="user-select: auto !important;">[[3,20300401,10,8],[1,20300104,100,80]]</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h4 style="user-select: auto !important;">입출력 예 설명</h4>

<p style="user-select: auto !important;">입출력 예 #1</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">본문의 내용과 동일합니다.</li>
</ul>

<hr style="user-select: auto !important;">

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">cpp를 응시하는 경우 리스트는 배열과 동일한 의미이니 풀이에 참고해주세요.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">ex) 번호가 담긴 정수 <u style="user-select: auto !important;"><strong style="user-select: auto !important;">리스트</strong></u> <code style="user-select: auto !important;">numbers</code>가 주어집니다. =&gt; 번호가 담긴 정수 <u style="user-select: auto !important;"><strong style="user-select: auto !important;">배열</strong></u> <code style="user-select: auto !important;">numbers</code>가 주어집니다.</li>
</ul></li>
<li style="user-select: auto !important;">java를 응시하는 경우 리스트는 배열, 함수는 메소드와 동일한 의미이니 풀이에 참고해주세요.

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">ex) solution <u style="user-select: auto !important;"><strong style="user-select: auto !important;">함수</strong></u>가 올바르게 작동하도록 한 줄을 수정해 주세요. =&gt; solution <u style="user-select: auto !important;"><strong style="user-select: auto !important;">메소드</strong></u>가 올바르게 작동하도록 한 줄을 수정해 주세요.</li>
</ul></li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges