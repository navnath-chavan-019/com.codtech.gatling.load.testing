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

## 📊 Gatling Load Test Summary

### 🔍 **Overview**
The load test simulates user interactions with various API endpoints, including GET, POST, PUT, and DELETE operations. The duration of the test was approximately **27 seconds**, focusing on assessing the system's ability to handle requests under a specific user load.

---

### 📌 **Key Metrics**

#### 🕒 **Response Time Analysis**
- **Global Max:** 21242 ms  
- **Global Min:** 1163 ms  
- **Mean:** ~2135 ms  
- **Standard Deviation:** 1629 ms  
- Higher latency was observed particularly in failed requests (`KO`), which impacts the average.

#### 📈 **Number of Requests**
- **Total Requests:** 4000  
  - **Successful (OK):** 2700 (67.5%)  
  - **Failed (KO):** 1300 (32.5%)  
- Most failures are concentrated in the `Get User` endpoint.

#### 📊 **Request Execution Breakdown**
| Endpoint       | Total | OK  | KO  | Success Rate |
|----------------|-------|-----|-----|---------------|
| Get User       | 800   | 75  | 725 | 9.38%         |
| Create User    | 800   | 800 | 0   | 100%          |
| Update User    | 800   | 800 | 0   | 100%          |
| Delete User    | 800   | 800 | 0   | 100%          |

- **Get User API** has a significantly low success rate and is the primary failure point.

#### ❗ **Errors**
- **Handshake Timeout:** 
  - **Type:** `i.n.s.ssl.SslHandshakeTimeoutException`  
  - **Description:** Handshake timed out after 10000ms  
  - **Count:** 1300  
  - **Error Rate:** 32.5% of total requests

---

### 📈 **Performance Over Time**
- Users ramped up quickly and remained stable for most of the test before tapering off.
- All API calls were active and tracked, with consistent load until the end.

---

### 📉 **Response Time Distribution**
- The majority of `OK` responses were under 2000 ms.
- A visible number of `KO` responses occurred early and were mostly due to timeouts.

---

### 📊 **Response Time Percentiles Over Time**
- Percentile metrics (50th, 75th, 95th, 99th) show that:
  - A large portion of requests fell within a similar time range.
  - However, spikes in max response times skew overall results.

---

### 📦 **Number of Requests per Second**
- Peak request rate reached around **120 requests/second**, followed by a steady rate until the tapering phase.
- User count remained mostly stable during this period.

---

### 📦 **Number of Responses per Second**
- Response rates mirrored the request rate, with a notable chunk of successful (`OK`) responses.
- `KO` responses spiked mid-way through the test, highlighting performance pressure or resource limitations.

---

## ✅ **Conclusions**

### 🟢 **Overall Performance**
- **Stable execution** for most endpoints (POST, PUT, DELETE).
- Good throughput in terms of request/response handling.

### 🔴 **Failures**
- **High failure rate (32.5%)**, primarily in the `Get User` endpoint.
- Root cause: SSL handshake timeout indicating possible backend/server-side SSL configuration issues or resource exhaustion.

### 🟡 **Stability**
- Performance was mostly stable during the active user phase.
- Spike in failures suggests issues occur under stress or when nearing server limits.

### 🔧 **Improvement Areas**
1. **Investigate SSL timeout** on `Get User` endpoint.
2. **Optimize backend response time** (high average and max values).
3. **Add retries or timeouts handling logic** to improve robustness.
4. **Monitor backend infrastructure** during tests for resource spikes (e.g., CPU, memory).

---


## Gatling Result Chart
![Image](https://github.com/user-attachments/assets/c0a512e0-c59c-48bc-abb5-ae1f916bd1ff)
