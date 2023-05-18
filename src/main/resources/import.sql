insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth0', NOW(), false, NOW(), '지구 파괴', 'EARTH_DESTROY');
insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth1', NOW(), false, NOW(), '멤버 추가', 'MEMBER_CREATE');
insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth2', NOW(), false, NOW(), '멤버 삭제', 'MEMBER_DELETE');
insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth3', NOW(), false, NOW(), '사용자 비밀번호 리셋', 'USER_PASSWORD_RESET');
insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth4', NOW(), false, NOW(), '사용자 정보 수정', 'USER_UPDATE');
insert into authority (authority_id, created_at, deleted, modified_at, description, name) values ('auth5', NOW(), false, NOW(), '사용자 탈퇴 처리', 'USER_DELETE');

insert into role (role_id, created_at, deleted, modified_at, description, name) values ('role1', NOW(), FALSE, NOW(), '함께 일하는 사람들', 'MEMBER');
insert into role (role_id, created_at, deleted, modified_at, description, name) values ('role2', NOW(), FALSE, NOW(), '외부 이용 고객들', 'USER');

insert into user (user_id, created_at, deleted, modified_at, email, enabled, failed_attempt, locked, name, password, password_updated_at, phone) values ('member1', NOW(), False, NOW(), 'member@email.com', TRUE, 0, False, '멤버1', '{noop}1111', NOW(), '010-1234-5697');
insert into user (user_id, created_at, deleted, modified_at, email, enabled, failed_attempt, locked, name, password, password_updated_at, phone) values ('user1', NOW(), False, NOW(), 'user@email.com', TRUE, 0, False, '고객1', '{noop}1111', NOW(), '010-1234-4567');
insert into user (user_id, created_at, deleted, modified_at, email, enabled, failed_attempt, locked, name, password, password_updated_at, phone) values ('god0', NOW(), False, NOW(), 'god@email.com', TRUE, 0, False, '절대자', '{noop}1111', NOW(), '010-1234-1111');

insert into role_authority (role_id, authority_id) values ('role1', 'auth1');
insert into role_authority (role_id, authority_id) values ('role1', 'auth2');
insert into role_authority (role_id, authority_id) values ('role1', 'auth3');
insert into role_authority (role_id, authority_id) values ('role1', 'auth4');
insert into role_authority (role_id, authority_id) values ('role1', 'auth5');
insert into role_authority (role_id, authority_id) values ('role2', 'auth3');
insert into role_authority (role_id, authority_id) values ('role2', 'auth4');
insert into role_authority (role_id, authority_id) values ('role2', 'auth5');

insert into user_role (user_id, role_id) values ('user1', 'role2');
insert into user_role (user_id, role_id) values ('member1', 'role1');

insert into user_authority (user_id, authority_id) values ('god0', 'auth0');