# com.codtech.gatling.load.testing

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: NAVNATH VISHNU CHAVAN

*INTERN ID*: CT08WT10

*DOMAIN*: SOFTWARE TESTING

*DURATION*: 8 WEEKS

*MENTOR*: NEELA SANTOSH

## DESCRIPTION OF PROJECT:

Task: To perform advanced load testing of a web application using Gatling.

Note: This "Advanced load testing using Gatling" task is performed in InjelliJ IDEA by using 
Scala and Maven.

As per the following instructions, I performed load testing on a web application, and the result was as follows:

---

📋 Test Overview
Simulation Name: recordedsimulation (Load Testing)

Start Time: 2025-04-30 08:48:01

Duration: 71 seconds

Total Requests: 2800

Successful (OK): 2100 (75%)

Failed (KO): 700 (25%)

Main Error: status.find.in(200,201,202,203,204,205,206,207,208,209,304).find(401) – Indicates unauthorized errors (401 status).

📊 Global Statistics

Metric	Value
Requests Total	2800
OK Requests	2100 (75%)
KO Requests	700 (25%)
Min Response Time	1429 ms
Max Response Time	26480 ms
Mean Response Time	8552 ms
Standard Deviation	4975 ms
Percentiles (OK)	
- 50th	7547 ms
- 75th	8751 ms
- 95th	15179 ms
- 99th	24872 ms
📉 Detailed Request Analysis (Few Examples)

Request Name	Total	OK	KO	Mean Response (ms)	Error %
request_1	200	200	0	1429	0%
request_6	100	0	100	9745	100%
request_10	100	0	100	8142	100%
request_13	200	200	0	7802	0%
request_16	200	200	0	8734	0%
Many request groups show a 100% failure rate, especially those around request_6 to request_12.

📈 Graph Analysis
✅ Active Users Over Time
Users ramped up and dropped gradually.

Flat line near end indicates all virtual users completed their executions.

⏱ Response Time Distribution
Spikes between 6s–12s (6000–12000 ms).

Red bars (KO) indicate failed requests are common within this response window.

📐 Percentile Graphs
Shows wide range in response times.

95th and 99th percentiles significantly higher, indicating performance degradation for top requests.

🔄 Requests/Responses per Second
Request Rate: Peaked around 2200/sec.

Response Rate: Many KO (red) responses clustered together, indicating possible server/resource issue.

❌ Errors
Total Errors: 700 (100% of all KO)

Error Type: 401 Unauthorized

Likely due to:

Missing/expired token

Incorrect authentication headers

Session timeout or improper login setup

✅ Summary & Recommendations
Issues Identified:

High failure rate (25%) due to 401 errors.

Poor response times for some requests (up to 26 seconds).

Requests request_6 to request_12 are consistently failing.

Recommendations:

Fix Authentication: Ensure tokens/sessions are valid during test run.

Optimize Backend: High response times suggest performance bottlenecks.

Increase Test Duration: 71 seconds might be too short for sustained load testing.

Test in Stages: Split into warm-up, steady load, and stress phases.

Enable Logging: Investigate server logs for failures during peak times.

---

## Gatling Result Chart
![Image](https://github.com/user-attachments/assets/3f6dd4b8-f37f-462f-9629-ed6b2450ac92)
