CREATE TABLE passwordResetTokens (
	token_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	profile_id UUID NOT NULL REFERENCES profiles(profile_id),
	expiration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP + INTERVAL '24 hours',
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
)