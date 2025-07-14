FROM python:3.11-slim

#작업 디렉토리 설정
WORKDIR /app

# 종속성 복사 및 설치
COPY backend/requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

#앱 소스 복사
COPY backend/app ./app

# 프론트엔드 복사
COPY frontend ./frontend

# 포트 열기 (문서용)
EXPOSE 8000

# 서버 실행
CMD ["uvicorn", "app.main:app", "--host","0.0.0.0", "--port", "8000", "--reload"]