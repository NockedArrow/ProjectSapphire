#version 330 core

layout (location = 0) out vec4 color;

in DATA
{
	vec2 tc;
	vec3 position;
} fs_in;

uniform sampler2D tex;

void main()
{
		color = texture(tex, fs_in.tc);
	if (color.rbga == vec4(0.0f, 0.0f, 0.0f, 1.0f))
		discard;
}