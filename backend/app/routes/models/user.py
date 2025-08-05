from sqlalchemy import Column,String,Integer
from app.database import Base

class User(Base):
    __tablename__ = "users"  # DB테이블 이름

    id = Column(Integer,primary_key=True,index=True) # 고유 ID(자동 증가)
    username = Column(String(12),unique=True,index=True,nullable=False) # 사용자 이름 중복 불가 
    password = Column(String(20),nullable=True)
    password_confirm = Column(String, nullable=False)  # 비밀번호 확인
    email = Column(String(100), unique=True, index=True, nullable=False)  # 이메일, 중복 불가

    