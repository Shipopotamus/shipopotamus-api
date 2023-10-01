CREATE TABLE accounts
(
    id          UUID PRIMARY KEY,
    user_id     UUID                     NOT NULL,
    email       TEXT                     NOT NULL,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL,
    modified_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE authentication_methods
(
    id                         UUID PRIMARY KEY,
    account_id                 UUID                     NOT NULL REFERENCES accounts (id),
    authentication_method_type TEXT                     NOT NULL,
    created_at                 TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE email_password_authentications
(
    authentication_method_id UUID PRIMARY KEY         NOT NULL REFERENCES authentication_methods (id),
    email                    TEXT                     NOT NULL,
    encoded_password         TEXT                     NOT NULL,
    created_at               TIMESTAMP WITH TIME ZONE NOT NULL
);
