Микросервис Доставки

Сборка и установка в minikube
1) `gradle build`
2) `docker build -t gurok/arch_delivery .`
3) `docker push gurok/arch_delivery`
4) `kubectl create namespace arch-gur`
5) `helm install gorelov-kafka ./deployment/kafka/`
6) `helm install arch-delivery ./deployment/app/`
   `kubectl get pods -n arch-gur`
   
---

Для локального поднятия кафки: `docker-compose-kafka up`

Пример сообщения в Кафку:

{"orderId":"2fa85f64-5717-4562-b3fc-2c963f66afa6","event":"DELIVERY_CANCEL"}

---
### Очистка пространства:

- `helm uninstall arch-delivery`
- `kubectl delete namespace arch-gur`
- `helm uninstall gorelov-kafka`