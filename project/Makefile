.PHONY: migrate up down logs ps

migrate:
	docker compose up -d postgres
	docker compose run --rm migrate

up:
	docker compose up --build -d

down:
	docker compose down -v

logs:
	docker compose logs -f --tail=200

ps:
	docker compose ps