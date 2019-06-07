# How to generate vault aws role
1. Create aws secrets backend
	* command
	~~~~
	curl -H "X-Vault-Token: <token>" -X POST -d @mount.json https://<vault-host>/v1/sys/mounts/<aws-secrets-backend>
	~~~~
	* mount.json
	~~~~
	{
     "type": "aws",
      "config": {
        "force_no_cache": true,
        "default_lease_ttl": "10m",
        "max_lease_ttl": "25h"
      }
    }
	~~~~
2. Configure aws secrets backend
	* command: 
	~~~~
	curl -H "X-Vault-Token: <token>"  -X POST -d @config.json https://<vault-host>/v1/<aws-secrets-backend>/config/root
	~~~~
	* config.json:
	~~~~
	{
		"access_key": <awsAccessKey>,
		"secret_key": <awsSecretKey>,
		"region": "eu-central-1"
	}
	~~~~
3. Create role
	* command:
	~~~~
	curl -H "X-Vault-Token: <token>"  -X POST -d @role.json https://<vault-host>/v1/<aws-secrets-backend>/roles/<role>
	~~~~
	* role.json:
	~~~~
	{
		"credential_type": "iam_user",
		"policy_arns": <policy-arn>
	}
	~~~~
