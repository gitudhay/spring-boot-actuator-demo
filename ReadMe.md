# Spring Boot Actuator Demo Application
This is a Spring Boot Actuator Demo Application with Prometheus and Grafana for application monitoring.

- Spring Boot Version: 2.5.6
- Prometheus Version: 3.5.0
- Grafana Version: 12.1.1

## Prometheus:
Download URL: https://prometheus.io/download/

### Prometheus Configuration:

- Edit /home/local/BSILIND/udhayakumar.g/Softwares/Prometheus/prometheus-3.5.0.linux-amd64/prometheus.yml
- Under the scrape_configs section, add the following:

<pre>
- job_name: "spring-boot-actuator-demo"
  # metrics_path defaults to '/metrics'
  metrics_path: '/actuator/prometheus'
  scrape_interval: 5s
  # scheme defaults to 'http'.
  static_configs:
  - targets: ["localhost:8080"]
  # The label name is added as a label to any time series scraped from this config.
      labels:
        app: "prometheus"
</pre>

### service start script:
cd /home/local/BSILIND/udhayakumar.g/Softwares/Prometheus/prometheus-3.5.0.linux-amd64/
<br/>
./prometheus

URL: http://localhost:9090/
admin/admin


## Grafana :

Download URL: https://grafana.com/grafana/download

### CLI Installation steps for Ubuntu:

1.`sudo apt-get install -y adduser libfontconfig1 musl`
- adduser → creates system user for Grafana service.
- libfontconfig1 → font rendering library for dashboards.
- musl → lightweight C library required by Grafana binaries.

2.`wget https://dl.grafana.com/grafana-enterprise/release/12.1.1/grafana-enterprise_12.1.1_16903967602_linux_amd64.deb`

- Downloads Grafana Enterprise v12.1.1 for Linux (amd64).

3.`sudo dpkg -i grafana-enterprise_12.1.1_16903967602_linux_amd64.deb`

Installs Grafana Enterprise into the system.
- Configuration files → /etc/grafana/
- Binary → /usr/sbin/grafana-server

4.`sudo systemctl enable grafana-server`
- Enables Grafana service to start on system boot.

5.`sudo systemctl start grafana-server`
- Starts Grafana service.

6.`sudo service grafana-server status`
- Checks the status of Grafana service.

### Grafana Configuration:

URL: http://localhost:3000/
<br/>
admin/admin
- Step1: Configure the Prometheus data source
<pre> 
Configuration - Data Sources - Click on: Add data source then select Prometheus. 
Mention the prometheus URL : http://localhost:9090/
Click on Save & Test.
Click on Back.
</pre>
- Step3: Create a new dashboard.
<pre> 
Click on + sign 
    Either select Add empty panel.
    - Give the prometheus metrics like jvm_buffer_memory_used_bytes etc and create a graph. 
(OR) 
Click on + sign 
    Select Import 
    Select the json file (Sample Spring boot dashboard JSON - https://grafana.com/grafana/dashboards/12900-springboot-apm-dashboard/) .
    Select the Prometheus data source.
    Click on Import.
</pre>

- Step3: Configuring email alerts.
<pre> 
Click on Alerting.
Click on New Alert.
</pre>

<br/><br/>

## ReadMe.md file syntax reference:
- https://www.markdownguide.org/basic-syntax/
- https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
