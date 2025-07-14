#어디서 앱이 시작되며 어떤기능이 연결되는지 중앙통제해주는 역할
import os
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from app.routes import user, group
from fastapi.staticfiles import StaticFiles


BASE_DIR = os.path.dirname(os.path.abspath(__file__))
ROOT_DIR = os.path.dirname(os.path.dirname(BASE_DIR))  # kiosk/
FRONTEND_DIR = os.path.join(BASE_DIR, "../frontend")


app = FastAPI()

# CORS 설정
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods =["*"],
    allow_headers=["*"]
)

#라우터 등록
app.include_router(user.router, prefix="/api/users")
app.include_router(group.router, prefix="/api/group")

if os.path.isdir(FRONTEND_DIR):
    app.mount("/", StaticFiles(directory=FRONTEND_DIR, html=True), name="frontend")
else:
    print(f"❌ FRONTEND_DIR does not exist: {FRONTEND_DIR}")

# 기본 엔드포인트
@app.get("/api")
def read_root():
    return {"message" : "FASTAPI 서버가 실행 중입니다."}