CREATE TABLE tasks (
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title text NOT NULL,
    content text,
    point integer
);
